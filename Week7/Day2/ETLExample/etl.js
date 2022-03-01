const { default: axios } = require('axios');
const csv = require('csv-parser');
const fs = require('fs');
const {Client} = require('pg');
const mongoose = require('mongoose');
const {Music} = require('./music.js');
const createCsvWriter = require('csv-writer').createObjectCsvWriter;


const mongoURI = 'mongodb+srv://revauser:p4ssw0rd@cluster0.flgkt.mongodb.net/musicdb?retryWrites=true&w=majority';

async function makeSpotifyCall(url){
    return axios.get(url, {
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
}

//Extact Transform Load

//We first need to extract all of our data from our different data sources
async function extractCSVData(){
    let data = [];

    await fs.createReadStream('rock.csv')
        .pipe(csv())
        .on('data', (row) => {
            let track = {
                id: row.id,
                name: row.name,
                artist: row.artist,
                album: row.title,
                duration: row.duration,
                trackNumber: row.trackNumber,
                releaseDate: row.releaseDate,
                trackUrl: row.trackUrl
            };
            data.push(track);
        }). on('end', () => {
            console.log(data);
        });

        return data;
}

//extractCSVData();

async function extractChinookData(){
    let data = [];

    const client = new Client({
        user: 'chinook',
        host: process.env.DB_URL,
        database: 'chinook',
        password: process.env.DB_PASSWORD,
        port: 5432
    });

    client.connect();

    const query = 'select t.trackid as id, t.name, t.composer, t.milliseconds, a3.albumid as albumid, a3.title as albumname, a3.name as artist from track t inner join (select * from album a inner join artist a2 on a.artistid = a2.artistid) as a3 on t.albumid = a3.albumid';

    try{
        data = await client.query(query);
    } catch(e){
        console.log(e);
    }

    console.log(data.rows);

    client.end();

    return data.rows;
}

//extractChinookData();

async function extractHipHopData(){

    //Js has a function called Promise all, which will return whatever data after each promise
    //In an array has been resolved
    const allHipHop = Promise.all([
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=0&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=100&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=200&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=300&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=400&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=500&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=600&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=700&limit=100')
    ]);

    //Destructuring
    const [req1, req2, req3, req4, req5, req6,req7, req8] = await allHipHop;

    let data = [
        ...req1.data.items,
        ...req2.data.items,
        ...req3.data.items,
        ...req4.data.items,
        ...req5.data.items,
        ...req6.data.items,
        ...req7.data.items,
        ...req8.data.items,
    ];

    fs.writeFileSync('all-hiphop.json', JSON.stringify(data));

    console.log(data);

    return data;

}

//extractHipHopData();

async function extractThisFire(){
    const allThisFire = Promise.all([
        makeSpotifyCall('https://api.spotify.com/v1/playlists/22h7UbYTTQxtQ3gtOmnAGe/tracks?offset=0&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/22h7UbYTTQxtQ3gtOmnAGe/tracks?offset=100&limit=100')
    ]);

    const [req1, req2] = await allThisFire;

    let data = [
        ...req1.data.items,
        ...req2.data.items
    ];

    //fs.writeFileSync('fire.json', JSON.stringify(data));

    //console.log(data);

    return data;
}

//extractThisFire();

async function extractCountry(){
    const allCountry = Promise.all([
        makeSpotifyCall('https://api.spotify.com/v1/playlists/5dAG5sZ5IN8yDwGqOQqrNM/tracks?offset=0&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/5dAG5sZ5IN8yDwGqOQqrNM/tracks?offset=100&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/5dAG5sZ5IN8yDwGqOQqrNM/tracks?offset=200&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/5dAG5sZ5IN8yDwGqOQqrNM/tracks?offset=300&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/5dAG5sZ5IN8yDwGqOQqrNM/tracks?offset=400&limit=100')
    ]);

    const [req1, req2, req3, req4, req5] = await allCountry;

    let data = [
        ...req1.data.items,
        ...req2.data.items,
        ...req3.data.items,
        ...req4.data.items,
        ...req5.data.items
    ];

    console.log(data);

    fs.writeFileSync('country.json', JSON.stringify(data));

    return data;
}

//extractCountry();

async function extractData(){

    let extracted = Promise.all([
        extractHipHopData(),
        extractThisFire(),
        extractCountry(),
        extractCSVData(),
        extractChinookData()
    ]);

    const [hiphop, thisfire, country, csv, chinook] = await extracted;
    let data = [...hiphop, ...thisfire, ...country, ...csv, ...chinook];

    console.log(data.length);

    return data;

}

//extractData();

async function transformData(data){
    //strip the unneeded data
    //We only want the artist, song name, duration, album
    let transformed = data.map((track) => {
        //For each trach in the data array, create a new track in the transformed array
        
        //The data from our database has an artist and miliseconds field
        if(track.artist && track.milliseconds){
            return {
                trackName: track.name,
                artistName: track.artist,
                album: track.albumname,
                duration: track.milliseconds
            }
        }

        //Our csv data has an artist and duration field
        if(track.artist && track.duration){
            return {
                trackName: track.name,
                artistName: track.artist,
                album: track.title,
                duration: track.duration
            }
        }

        //The data directly from spotify has an track field
        if(track.track){
            return{
                trackName: track.track.name,
                artistName: track.track.artists[0].name,
                album: track.track.album.name,
                duration: track.track.duration_ms
            }
        }
    });

    console.log(transformed);
    return transformed;
}

async function transformDuration(data){
    let transformed = data.map((song) => {
        let seconds = song.duration / 1000;
        return {
            trackName: song.trackName,
            artistName: song.artistName,
            album: song.album,
            duration: seconds
        }
    });

    console.log(transformed);
    return transformed;
}

async function filterSongs(data){
    let transformed = data.filter((song) => {
        if(song.duration > 60 && song.duration < 600){
            return song;
        }
    });

    console.log(transformed);
    return transformed;
}

async function loadData(data){
    let numberOfLoaded = 0;
    await mongoose.connect(mongoURI, {useNewUrlParser: true, useUnifiedTopology: true});

    for(let track of data){
        console.log('Processing: ', track);
        let song = new Music(track);
        await song.save();
        numberOfLoaded++;
        console.log(`Processed: ${numberOfLoaded}`);
    }

    mongoose.connection.close();

    const csvWriter = createCsvWriter({
        path: 'transformed.csv',
        header: [
            {id: 'trackName', title: 'trackName'},
            {id: 'artistName', title: 'artistName'},
            {id: 'album', title:'album'},
            {id: 'duration', title: duration}
        ]
    });

    csvWriter.writeRecords(data)
    .then(() => console.log('CSV file was written'));
}

async function etlPipeline(){
    let data = await extractData();
    let normalizedData = await transformData(data);
    let durationToSeconds = await transformDuration(normalizedData);
    let transformedData = await filterSongs(durationToSeconds);
    await loadData(transformedData);
}

//etlPipeline();

//Lets query our db and find out what the average length of a certain artists song is
async function findAverageSongLength(artist){
    await mongoose.connect(mongoURI, {useNewUrlParser: true, useUnifiedTopology: true});

    let songs = await Music.find({artistName: artist});

    console.log(songs);

    let totalDuration = 0;

    for(let song of songs){
        totalDuration += song.duration;
    }

    let average = totalDuration/songs.length;

    let minutes = Math.floor(average/60);
    let seconds = ((average/60) - Math.floor(average/60))*60;
    if(seconds < 10){
        seconds = `0${Math.floor(seconds)}`;
    }
    else{
        seconds = Math.floor(seconds);
    }
    
    let duration = `${minutes}:${seconds}`;

    mongoose.connection.close();

    console.log(`The average duration of ${artist}'s songs found in the database is: ${duration}`);
}

findAverageSongLength('Pink Guy');
const mongoose = require('mongoose');

const Music = new mongoose.Schema({
    trackName: String,
    artistName: String,
    album: String,
    duration: Number
});

module.exports.Music = mongoose.model('Music', Music);
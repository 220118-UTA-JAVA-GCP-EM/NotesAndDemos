/*
let courses = [
    {
        course: 'MATH110',
        name: 'Intro to math',
        description: 'Learn the basics of math'
    },
    {
        course: 'READ110',
        name: 'Intro to reading',
        description: 'Learn to read'
    },
    {
        course: 'MATH110',
        name: 'Intro to math',
        description: 'Learn the basics of math'
    },
    {
        course: 'READ110',
        name: 'Intro to reading',
        description: 'Learn to read'
    },
    {
        course: 'SCI110',
        name: 'Intro to science',
        description: 'Learn to science'
    }
];
*/
let courses;

//We can grab the element of the div we want to store the courses in
let courseContainer = document.getElementById('courses-container');
console.log(courseContainer);

//We want to add all of our courses to the webpage, so we will loop through the list of courses
function populateCourses(courses){
    for(course of courses){
        //For each course in the course list, create a new div
        let cDiv = document.createElement('div');
        console.log(cDiv);

        //set the innerHTML of the new div
        cDiv.innerHTML = `
            <h2>${course.subject}${course.number}</h2>
            <h3>${course.name}</h3>
            <h3>Taught by: ${course.teacher ? course.teacher.first + ' ' + course.teacher.last : 'N/A'}</h3>
        `;

        console.log(cDiv);
        cDiv.setAttribute('class', 'course');

        //Finally we can append the courses to the container
        courseContainer.append(cDiv);
    }
}

const URL = 'http://localhost:7000';

let showForm = false;
let newCourseForm = document.getElementById('new-course');

let button = document.getElementById('add-course-btn').addEventListener('click', ()=> {
    showForm = !showForm;
    showForm ? newCourseForm.setAttribute('class', 'show-form') : newCourseForm.setAttribute('class', 'hide-form');
})

//Doing it the old fashioned way with XHR object :)
//For now, we will use an immediately invoked function
//There are 4 steps in making an AJAX Request
/*
(()=> {

    //Step 1. Create the new XHR object
    let xhttp = new XMLHttpRequest();

    //Step 2. Create a callback function for readystatechange
    xhttp.onreadystatechange = getData = () => {
        if(xhttp.readyState === 4 && xhttp.status === 200){
            console.log(xhttp.responseText);
            let res = JSON.parse(xhttp.responseText);
            populateCourses(res);
        }
    }

    let apiUrl = `${URL}/courses`;

    //Step 3. Open the request
    xhttp.open('GET', apiUrl);

    //Step 4. Send the request
    xhttp.send();

})();
*/

//Basic Promise Syntax
let promise = new Promise(function(resolve, reject){
    const x = 5;
    const y = 3;

    if(x>=y){
        resolve(x);
    }
    else {
        reject();
    }
});

//Chain the promise with consumer functions
promise
    .then((x) => x*2)
    .then((y) => y*3)
    .then((z) => console.log(z*4));

//Lets look at the other consumer functions
promise
    .then(() => console.log('We resolved'))
    .catch(() => console.log('There was an error'))
    .finally(() => console.log('This runs no matter what'));
/*
//Refactor the above AJAX with fetch and promises
(()=>{

    let apiUrl = `${URL}/courses`;

    fetch(apiUrl)
        .then((res) => res.json())
        .then((data) => populateCourses(data));

})();

//Lets take a look at the response headers
(function responseHeaders(){
    let apiUrl = `${URL}/courses`;
    fetch(apiUrl).then((res) => console.log('Headers, ', res.headers));
})();

//We can set request headers by including an object in the fetch call
(function requestHeaders(){
    let apiUrl = `${URL}/courses`;
    fetch(apiUrl, {
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then((res) => res.json())
    .then((data) => console.log(data));
})();

//How to create a post request with Fetch
let submitCourse = document.getElementById('submit-course').addEventListener('click', post);

function post(){
    let number = document.getElementById('number').value;
    let name = document.getElementById('name').value;
    let subject = document.getElementById('subject').value;

    console.log(number, name, subject);

    let courseObj = {
        courseId: 0,
        subject,
        number,
        name,
        teacher: {

        },
        students: [],
        topics: []
    }

    let apiUrl = `${URL}/course`;

    fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(courseObj)
    })
    .then((res) => res.json())
    .then((data) => console.log(data));

}
*/

//One last refactor, we will use fetch with async/await

(async () => {
    let req = await fetch(`${URL}/courses`);
    let res = await req.json();
    console.log(res);
    courses = res;
    courseContainer.innerHTML="";
    populateCourses(courses);
})();

let post = async () => {
    let number = document.getElementById('number').value;
    let name = document.getElementById('name').value;
    let subject = document.getElementById('subject').value;

    let courseObj = {
        courseId: 0,
        subject,
        number,
        name,
        teacher: {

        },
        students: [],
        topics: []
    };

    let req = await fetch(`${URL}/course`, {
        method: 'POST',
        //headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(courseObj)
    });
    let res = await req.json();
    res.teacher = null;
    courses.push(res);
    console.log(res);
    courseContainer.innerHTML="";
    populateCourses(courses);
}

let submitCourse = document.getElementById('submit-course').addEventListener('click', post);
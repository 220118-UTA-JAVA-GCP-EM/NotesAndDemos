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

//We can grab the element of the div we want to store the courses in
let courseContainer = document.getElementById('courses-container');
console.log(courseContainer);

//We want to add all of our courses to the webpage, so we will loop through the list of courses
for(course of courses){
    //For each course in the course list, create a new div
    let cDiv = document.createElement('div');
    console.log(cDiv);

    //set the innerHTML of the new div
    cDiv.innerHTML = `
        <h2>${course.course}</h2>
        <h3>${course.name}</h3>
        <p>${course.description}</p>
    `;

    console.log(cDiv);
    cDiv.setAttribute('class', 'course');

    //Finally we can append the courses to the container
    courseContainer.append(cDiv);
}
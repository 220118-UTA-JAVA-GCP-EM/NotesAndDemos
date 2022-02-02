let bubbleElements = document.getElementsByClassName('bubble');
for(el of bubbleElements){
    el.addEventListener('click', bubble);
    el.addEventListener('click', viewTarget);
    el.addEventListener('click', stopProp);
}

function bubble(){
    alert(`Bubbling ${this.tagName}`);
}

let captureElements = document.getElementsByClassName('capture');
for(el of captureElements){
    el.addEventListener('click', alterName, true);
    el.addEventListener('click', stopImProp, true);
}

function alterName(){
    alert(`Captured ${this.tagName}`);
}

//We can view the target element from the event
function viewTarget(event){
    console.log(event.target);
}

//To stop the propagation
function stopProp(event){
    event.stopPropagation();
}

//If for some reason stopPropagation does not work, you can try stopImmediatePropagation
function stopImProp(event){
    event.stopImmediatePropagation();
}

//Lets create the function print pressed, otherwise if we type into the username field chrome will cry
function printPressed(event){
    console.log(`Key pressed in username field: ${event.key}`);
}

//Add an event listener to the password input
let passwordField = document.getElementById('password');
passwordField.addEventListener('keydown', passwordPress);

function passwordPress(event){
    console.log(`Key pressed in password field: ${event.key}`);
}

//If we want to do some custom logic before sending our data away, we can prevent the form
// from doing its default action
let login = document.getElementById('form');
login.addEventListener('submit', submitForm);

function submitForm(event){
    event.preventDefault();
    console.log('We are preventing the default functionality of the form');
    console.log(`The username was ${document.getElementById('username').value}`);
    console.log(`The password was ${document.getElementById('password').value}`);
    login.reset();
}
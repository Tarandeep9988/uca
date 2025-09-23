// Promise

// Promise is an object created using Promise constructor function and primarliy have two properties
// 1. state - possible values
// - pending
// - fulfilled
// - rejected

// 2. result - possible values
// - undefined
// - value
// - error

// Simple promise

function promiseExecutor() {
  // Async operation
  setTimeout(() => {
    console.log("Promise 1 executed");
  }, 5000);
}

// var promise1 = new Promise(promiseExecutor);

// Executor function is called immediately when promise is created
// Executor function is called with 2 arguments of type function - resolve and reject
// resolve and reject are functions


// Simple promise with resolve and reject
function promiseExecutor(resolve, reject) {
  // Async operation
  setTimeout(() => {
    console.log("Promise 2 executed");
    resolve("Promise 2 resolved");
    reject("Promise 2 rejected")
  }, 5000);
}

const promise2 = new Promise(promiseExecutor);
console.log(promise2);
promise2
.then((res) => {
  console.log(res);
})
.catch((err) => {
  console.error(err);
})
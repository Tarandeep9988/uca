// var promise1 = new Promise(promiseExecutor);
// var promise1 = new PromiseCustom(promiseExecutor);

// Simple Promise with constructor function
// Simple Promise with resolve and reject
// Simple Promise with additional then and catch methods

function promiseExecutor() {
  // Async operation
  setTimeout(() => {
    console.log("Promise 2 executed");
  }, 5000);
}

function PromiseCustom(executor) {
  this.state = "pending";
  executor();
}

var customPromise1 = new PromiseCustom(promiseExecutor);


// Simple Promise with resolve and reject
function customPromiseExecutor(resolve, reject) {
  
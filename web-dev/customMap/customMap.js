
// Defining array
const arr = [1, 2, 3, 4, 5];
arr = [1,1,2,,3,,,,,4]// stagered aray
arr[3]
// Using normal map
console.log(arr.map((e) => (e * e)));

// Implementing my own customMap
Array.prototype.customMap = function (callback) {
    // Checking if it is even this is null or undefined
    if (this == null) {
        throw new TypeError("Cannot read property 'customMap' of null or undefined");
    }

    if (typeof callback !== 'function') {
        throw new TypeError(callback + " is not a Function!");
    }

    const arr = new Array(this.length);
    for (let i = 0; i < this.length; i++) {
        // handling sparse arrays
        if (i in this) {
            arr[i] = callback(this[i], i, this);
        }
    }
    return arr;
}

// Using custom map
console.log(arr.customMap((e) => (e * e * e)));

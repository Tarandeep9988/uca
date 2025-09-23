// Class in js

/** 
 * Es6
 *  Class specification
 *    - constructor
 *    - inhertance possible
 */

// Problem
//  - Frameworks implemented class based approach much earlier then frameworks like React, Vue, etc.
//  - Browser implemented this earlier.

// Class in js
// Classes are just the syntactical sugar over the existing prototype-based inheritance in JavaScript.

class Student {
  constructor(name, obtainedMarks) {
    this.name = name;
    this.obtainedMarks = obtainedMarks;
  }
  maxMarks = 500;
  checkResult() {
    let percentage = (this.obtainedMarks / this.maxMarks) * 100;
    if (percentage >= 35) {
      console.log(this.name + " has passed.");
    } else {
      console.log(this.name + " has failed.");
    }
  }
}

var student1 = new Student("John", 85);
student1.checkResult();


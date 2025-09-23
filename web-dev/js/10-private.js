var maxMarks = 100;
class Student {
  #fname
  constructor(fName, obtainedMarks) {
    this.#fname = fName;
    this.obtainedMarks = obtainedMarks;
  }
  #checkResult() {
    let percentage = (this.obtainedMarks / maxMarks) * 100;
    if (percentage >= 40) {
      console.log(`${this.#fname} has passed the exam.`);
    } else {
      console.log(`${this.#fname} has failed the exam.`);
    }
  }
  getName() {
    return this.#fname;
  }
  checkResult2() {
    this.#checkResult();
  }
}

var s1 = new Student("John", 350);
console.log(s1.getName());
s1.checkResult2();


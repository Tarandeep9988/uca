function sum(...args) {
    return args.reduce((a, b) => a + b, 0);
}

function multiply(...args) {
    return args.reduce((a, b) => a * b, 1);
}

export { sum, multiply };
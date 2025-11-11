import Card from "./card";

export default async function Content() {
  function sleep(sleepTime) {
    return new Promise((resolve) => setTimeout(resolve, sleepTime));
  }

  await sleep(5000);
  // const products = await fetch("https://fakestoreapi.com/products"); 
  return (
    <div style={{display: "flex", justifyContent: "center"}}>
      <Card />
      <Card />
      <Card />
      <Card />
    </div>
  );
}
export default async function Others({ params}) {
  const {productID} = await params;
  return (
    <div>
      <h2>Others Page</h2>
      <p>Product IDs: {productID}</p>
    </div>
  );
}
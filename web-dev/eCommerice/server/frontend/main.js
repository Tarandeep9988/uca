
var app = document.getElementById('reactapp');
var root = ReactDOM.createRoot(app);
root.render(<DescriptionComponent name = "Valid Name" />);

function DescriptionComponent ({name}) {
  return (
    <>
      <h1>React Managed code {name ?? "Guest User"}</h1>
      <p>Web site description here</p>
    </> 
  )
} 
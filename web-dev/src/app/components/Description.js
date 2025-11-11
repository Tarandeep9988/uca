"use client";

import { useEffect, useState } from "react"

const Description = () => {
  useEffect(() => {
    console.log("Description component mounted");
  }, []);
  return (
    // Beautiful Description component
    <div>
      <p>This is a description component.</p>
      <p>It is used to display descriptive text.</p>
      <p>It can be reused across different parts of the application.</p>    
    </div>
  )
}

export default Description
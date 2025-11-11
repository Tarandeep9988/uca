import Link from "next/link";
import Header from "./components/header";
import Content from "./components/content";
import { Suspense } from "react";

export default function Home() {
  

  return (
    <main>
      <Header />
      <h1>Welcome to My Next.js App</h1>
      <Link href="/login">Go to Login Page</Link>
      <Suspense fallback={<div>Loading content...</div>}> <Content /></Suspense>
      
    </main>
  );
}

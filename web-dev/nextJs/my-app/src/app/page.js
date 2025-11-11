import Link from "next/link";

export default function Home() {
  return (
    <>
      <h1>Welcome to Home Page</h1>
      <Link href="/login">Go to Login</Link>
    </>
  )
}

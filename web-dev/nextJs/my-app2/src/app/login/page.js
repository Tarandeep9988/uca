import Link from "next/link";

export default function Login() {
  return (
    <form>
      <h2>Login page</h2>
      <label>Username:</label>
      <input type="text" name="username" />
      <br />
      <label>Password:</label>
      <input type="password" name="password" />
      <br />
      <button type="submit">Login</button>
      <br />
      <Link href="/">Go back to Home</Link>
    </form>
  );
}
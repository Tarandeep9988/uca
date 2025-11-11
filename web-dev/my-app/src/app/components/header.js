import Link from "next/link";

function Header () {
    return (
        <header>
            <Link href="/">
                <h1>My E-commerce Site</h1>
            </Link>
        </header>
    ); 
}

export default Header;
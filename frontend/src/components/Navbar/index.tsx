import { ReactComponent as GitHubIcon } from 'assets/images/github.svg';
import './styles.css';

function Navbar() {
    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>DSMovie</h1>
                    <a href="https://github.com/laaandrd">
                        <div className="dsmovie-contact-container">
                            <GitHubIcon />
                            <p className="dsmovie-contact-link">/laaandrd</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;
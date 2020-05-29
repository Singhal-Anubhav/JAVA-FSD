import React from 'react';
import "../Containers/style.css"

const Header=(props)=>{
    return(
        <header className="header">
            <nav className="headerMenu">
                <a href="http://localhost:8080/seasons">Seasons</a>
                <a href="http://localhost:8080/leagues">Leagues</a>
                <a href="http://localhost:8080/gameLive">Live Matches</a>
            </nav>

        </header>
    )
}

export default Header

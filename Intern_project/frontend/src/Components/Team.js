import React from 'react'

const Team = (props) => {
    return (
        <div className="team__info">
        {
            props.city && <p className="team__key"> City :
            <span className="team__value"> {props.city}</span>
            </p>
        }
        {
            props.fullName && <p className="team__key"> FullName :
            <span className="team__value"> {props.fullName}</span>
            </p>
        }
        {
            props.nickname && <p className="team__key"> NickName :
            <span className="team__value"> {props.nickname}</span>
            </p>
        }
        {
            props.leagues && <p className="team__key"> Leagues :
            <span className="team__value"> {props.leagues} </span>
            </p>
        }
        {
            props.error && <p className="team__error">{props.error} </p>
        }
    </div>

    )
}

export default Team

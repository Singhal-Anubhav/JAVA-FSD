import React from 'react'

const Team = (props) => {
    return (
        <div className="team__info">
        {
            props.city && props.country && <p className="team__key"> City:
            <span className="team__value"> {props.city}</span>
            </p>
        }
        {
            props.temprature && <p className="weather__key"> FullName:
            <span className="weather__value"> {props.fullName} °C	</span>
            </p>
        }
        {
            props.humidity && <p className="team__key"> NickName:
            <span className="team__value"> {props.nickname} %</span>
            </p>
        }
        {
            props.description && <p className="team__key"> logo:
            <span className="team__value"> {props.logo} </span>
            </p>
        }
        {
            props.error && <p className="team__error">{props.error} </p>
        }
    </div>

    )
}

export default Team
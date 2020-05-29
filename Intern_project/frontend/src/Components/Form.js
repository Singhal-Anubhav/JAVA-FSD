import React from 'react'

const Form = (props) => {
    return (
        <div>
            <form onSubmit={props.getTeam}>
                <input type='text' id="teamId" name="teamId" placeholder="TeamId..."></input>
                <button>Get Team Details</button>
            </form>
        </div>
    )
}

export default Form

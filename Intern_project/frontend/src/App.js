import React, { Component } from 'react';
import './App.css';
// import Header from './Components/index';
import Form from './Components/Form';
import Team from './Components/Team';
import Title from './Components/Title'

class App extends Component{

  state = {
    city:undefined,
    fullName:undefined,
    nickname:undefined,
    leagues:undefined,
    error:undefined

  }

  getTeam = async (e) => {
    const teamId = e.target.elements.teamId.value
    e.preventDefault();
    if (teamId) {
      const api_call = await fetch(`http://localhost:8080/teamById/${teamId}`)
      const data = await api_call.json()
      console.log(data);
      // if((data.cod == "404")&&(data.message == "teamId not found")){
      //   this.setState({
      //     city:undefined,
      //     fullName:undefined,
      //     nickname:undefined,
      //      logo:undefined,
      //     error:"teamId not found"});
      // }
      // else{
        this.setState({
        city: data.api.teams[0].city,
        fullName: data.api.teams[0].fullName,
        nickname: data.api.teams[0].nickname,
        leagues: JSON.stringify(data.api.teams[0].leagues.standard),
        error: ''
      });
      console.log(teamId);
    // }
  }


}

render(){
    return (
      <div className="wrapper">
        <div className = "main">
          <div className = "container">
            <div className ="row">
              <div className = "col-xs-7 title_container">
                <Title/>
              </div>
              <div className = "form-container">
              <Form getTeam={this.getTeam} />
              <Team
                city={this.state.city}
                fullName={this.state.fullName}
                nickname={this.state.nickname}
                leagues={this.state.leagues}
                error={this.state.error}
              />
              </div>
            </div>
          </div>     
        </div>
      </div>

    );
  }
  }
  
export default App

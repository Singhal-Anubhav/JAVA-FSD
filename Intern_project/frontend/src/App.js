import React, { Component } from 'react';
import './App.css';
import Header from './Components/index';
import Form from './Components/Form';
import Team from './Components/Team';


class App extends Component{

  state = {
    city:undefined,
    fullName:undefined,
    nickname:undefined,
    logo:undefined,
    error:undefined

  }

  getTeam = async (e) => {
    const teamId = e.target.elements.teamId.value
    e.preventDefault();
    if (teamId) {
      const api_call = await fetch(`hhttp://localhost:8080/teamById?teamId=${teamId}`)
      const data = await api_call.json()
      console.log(data);
      if((data.cod == "404")&&(data.message == "teamId not found")){
        this.setState({
          city:undefined,
          fullName:undefined,
          nickname:undefined,
           logo:undefined,
          error:"teamId not found"});
      }
      else{
        this.setState({
        city: data.teams.city,
        fullName: data.teams.fullName,
        nickname: data.teams.nickname,
        logo: data.teams.logo,
        error: ''
      })
    }
  }


}

render(){
    return (
      <div className="App">
        <div>
        <Header/>
        </div>
        <div>
     
                  <Form getTeam={this.getTeam} />
                  <Team
                    city={this.state.city}
                    fullName={this.state.fullName}
                    nickname={this.state.nickname}
                    logo={this.state.logo}
                    error={this.state.error}
                  />
              
      </div>
      </div>

    );
  }
  }
  
export default App
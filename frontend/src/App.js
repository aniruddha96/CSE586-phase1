import './App.css';
import Row from 'react-bootstrap/Row';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Alert, Form, InputGroup, FormGroup, FormControl, Button } from 'react-bootstrap';
import {useState} from 'react';


function App(props) {
  const [alertVisibleP, setAlertVisibleP] = useState(false)
  const [alertVisibleS, setAlertVisibleS] = useState(false)

  const [name,setName] = useState("Aniruddha")
  const [checkInTime,setCheckInTime] = useState("today")
  return (
    
    <div className="App">
      <header className="App-header">
        <Row className="mx-2">
          <Form.Group className="mb-4" controlId="id1">
            <Form.Control onChange= {e=>setname(e)} type="text" placeholder="Enter you name" />
            <Button variant="primary" type="submit" onClick= {checkIn} >
              Submit
            </Button>
          </Form.Group>
          <Alert variant ='primary' show = {alertVisibleP}>Welcome back {name}, your last checkin was {checkInTime}</Alert>
          <Alert variant ='success' show = {alertVisibleS}>Welcome {name}, your checkin is {checkInTime}</Alert>
        </Row>
      </header>
    </div>
  );

function setname(e){
  setName(e.target.value)
  setAlertVisibleP(false);
  setAlertVisibleS(false);
}
function checkIn(){
  const requestOptions = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({userName: name})
};
fetch('http://localhost:8080/checkin', requestOptions)
    .then(response => response.json())
    .then(data =>{
      console.log(data); 
      setCheckInTime(data.checkinTimeString) ;
      if(data.new==true){
        setAlertVisibleS(true);
        setAlertVisibleP(false);
      }else{
        setAlertVisibleP(true);
        setAlertVisibleS(false);
      }
    });
}

}

export default App;

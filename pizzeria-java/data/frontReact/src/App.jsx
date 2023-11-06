import { useState } from 'react'
import './App.css'
import { useEffect } from 'react';

const URL = 'http://localhost:8090/pizzeria/orders';
const auth = 'Basic dXNlcjoxNjg4NjFjNi0wYTE0LTQ0MmItODgyZi03OWVjOGNkOWNmMzg=';

function App() {

  const [pizza, setPizza] = useState();


  useEffect(() => {
    fetch(URL, {
      method: "GET",
      headers: {
        'Content-Type': 'application/json',
        'Authorization': auth
      }
      
    })
      .then(res => {
        if (res.ok) {
          return res.json();
        } else {
          throw new Error('La solicitud no fue exitosa')
        }
      })
      .then(data => setPizza(data))
  }, [])

  return (
    <>
      <h1>Hello Pizza!</h1>
      {
        JSON.stringify(pizza)
      }
    </>
  )
}

export default App

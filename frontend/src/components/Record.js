import React, { useEffect, useState } from "react";

export default function Record() {
  const [name, setName] = useState('')
  const [rollNumber, setRollNumber] = useState('') 
  const [records, setRecords] = useState([])
  const handleClick = (e) => {
    e.preventDefault();
    const record = {name, rollNumber}
    fetch("http://localhost:8080/demoapi/add-record", {
      method: "POST",
      headers: {"Content-Type":"application/json"},
      body: JSON.stringify(record)
    }).then(() => {
      console.log("Record added successfully!")
    })
  }

  useEffect(() => {
    fetch("http://localhost:8080/demoapi/get-all-records")
    .then(res=>res.json())
    .then((result) => {
      console.log(result)
      setRecords(result)
    })
  },[])

  return (
    <div>
      <h1>Add Student</h1>
      <form noValidate autoComplete="off">
        Enter Name <input id="name" value={name} onChange={(e)=>setName(e.target.value)}/><br/>
        Enter Roll Number <input id="rollNumber" value={rollNumber} onChange={(e)=>setRollNumber(e.target.value)}/><br/>
      </form>
      <br/>
      Name = {name}, Roll Number = {rollNumber}
      <br/>
      <button onClick={handleClick}>Add record</button>
      <br/><br/>
      All Records
      {records.map(record => {
        return (
          <div id={record.id}>
            Id: {record.id}, Name: {record.name}, Roll_Number: {record.rollNumber}
          </div>
        )
      })}
    </div>
  );
}
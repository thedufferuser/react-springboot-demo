import React, { useState } from "react";

export default AllRecords() {
  const [id, setId] = useState('')
  const [name, setName] = useState('')
  const [rollNumber, setRollNumber] = useState('')
  const handleClick = (e) => {
    e.preventDefault()
    const record = [id, name, rollNumber]
    fetch()
  }
  return (
    <div>
      <button onClick={handleClick}>Get All Records</button>
    </div>
  )
}
// src/components/TechnicalStaffUI/TechnicalStaff.js

import React, { useState } from 'react';

function TechnicalStaff() {
  const [scheduleDate, setScheduleDate] = useState('');
  const [topicsTaught, setTopicsTaught] = useState('');
  const [assignment, setAssignment] = useState('');
  const [studentProgress, setStudentProgress] = useState('');

  const handleDateChange = (e) => {
    setScheduleDate(e.target.value);
  };

  const handleTopicsChange = (e) => {
    setTopicsTaught(e.target.value);
  };

  const handleAssignmentChange = (e) => {
    setAssignment(e.target.value);
  };

  const handleProgressChange = (e) => {
    setStudentProgress(e.target.value);
  };

  const handleSubmit = () => {
    // Logic to handle logsheet submission (mocking the process)
    alert('Logsheet submitted successfully!');
  };

  return (
    <div>
      <h2>Technical Staff UI</h2>

      <div>
        <label>Select Date: </label>
        <input type="date" value={scheduleDate} onChange={handleDateChange} />
      </div>

      <div>
        <label>Topics Taught (Lecture): </label>
        <input type="text" value={topicsTaught} onChange={handleTopicsChange} />
      </div>

      <div>
        <label>Assignment (Lab): </label>
        <input type="text" value={assignment} onChange={handleAssignmentChange} />
      </div>

      <div>
        <label>Student Progress: </label>
        <input type="text" value={studentProgress} onChange={handleProgressChange} />
      </div>

      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}

export default TechnicalStaff;

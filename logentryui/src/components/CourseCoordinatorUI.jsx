import React, { useState } from 'react';

function CourseCoordinator() {
  const [moduleName, setModuleName] = useState('');
  const [curriculumFile, setCurriculumFile] = useState(null);
  const [scheduleFile, setScheduleFile] = useState(null);

  const handleModuleChange = (e) => {
    setModuleName(e.target.value);
  };

  const handleCurriculumUpload = (e) => {
    setCurriculumFile(e.target.files[0]);
  };

  const handleScheduleUpload = (e) => {
    setScheduleFile(e.target.files[0]);
  };

  const handleSubmit = () => {
    // Logic to handle form submission (mocking the process)
    alert('Curriculum and Schedule uploaded successfully!');
  };

  return (
    <div className="min-h-screen bg-gray-100 py-10 px-5">
      <div className="max-w-3xl mx-auto bg-white p-8 rounded-lg shadow-md">
        <h2 className="text-3xl font-bold text-blue-600 mb-6 text-center">Course Coordinator UI</h2>
        
        <form onSubmit={handleSubmit}>
          {/* Course Selection */}
          <div className="mb-4">
            <label className="block text-gray-700 text-sm font-bold mb-2">Course</label>
            <select className="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
              <option>Select Course</option>
              <option>Course 1</option>
              <option>Course 2</option>
            </select>
          </div>

          {/* Module Name */}
          <div className="mb-4">
            <label className="block text-gray-700 text-sm font-bold mb-2">Module Name</label>
            <input
              type="text"
              value={moduleName}
              onChange={handleModuleChange}
              className="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
              placeholder="Enter Module Name"
            />
          </div>

          {/* Upload Curriculum */}
          <div className="mb-4">
            <label className="block text-gray-700 text-sm font-bold mb-2">Upload Curriculum</label>
            <input
              type="file"
              onChange={handleCurriculumUpload}
              className="w-full text-sm text-gray-700 px-4 py-2 file:bg-blue-50 file:text-blue-500 file:rounded-md file:px-3 file:py-1 hover:file:bg-blue-100"
            />
          </div>

          {/* Upload Schedule */}
          <div className="mb-4">
            <label className="block text-gray-700 text-sm font-bold mb-2">Upload Schedule</label>
            <input
              type="file"
              onChange={handleScheduleUpload}
              className="w-full text-sm text-gray-700 px-4 py-2 file:bg-blue-50 file:text-blue-500 file:rounded-md file:px-3 file:py-1 hover:file:bg-blue-100"
            />
          </div>

          {/* Submit Button */}
          <div className="text-center">
            <button
              type="button"
              onClick={handleSubmit}
              className="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-6 rounded-md shadow-md focus:outline-none focus:ring-2 focus:ring-blue-300"
            >
              Submit
            </button>
          </div>
        </form>

        {/* Reports Section */}
        <div className="mt-10">
          <h3 className="text-xl font-bold text-gray-700 mb-4">Reports</h3>
          <div className="bg-gray-50 p-4 rounded-lg shadow-md">
            <p className="text-lg text-gray-600 font-semibold">Module Progress Report (Lectures)</p>
            <p className="text-lg text-gray-600 font-semibold">Comparative Report (Scheduled vs Actual Hours)</p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default CourseCoordinator;

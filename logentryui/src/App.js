import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Import Router, Routes, Route
import CourseCoordinator from './components/CourseCoordinatorUI';
import TechnicalStaff from './components/TechnicalStaffUI';
import Login from './components/Login';

function App() {
  return (
    <Router>
      <Routes>
        {/* Correctly set the element prop with JSX syntax */}
        <Route path="/" element={<Login />} />

        <Route path="/coursecoordinator" element={<CourseCoordinator />} />
        <Route path="/technicalstaff" element={<TechnicalStaff />} />
      </Routes>
    </Router>
  );
}

export default App;

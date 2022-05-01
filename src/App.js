import AppFlights from './component/AppFlights';
import './App.css';
import Navbar from './component/Navbar';
import Data from './component/Data';


function App() {
  return(
      <div className="app">
          <Navbar/>
          <AppFlights/>
          <Data/>
      </div>
  )
   
}

export default App;

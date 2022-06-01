import {useState , useEffect} from 'react';
import axios from "axios";

function useFetch() {
    const [data , setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
           try {
             const res = await axios.get("http://localhost:8090/api/foods/getAll")
             setData(res.data);
           }catch (err) {
             console.log(err);
           }
        }
          fetchData();

     },[]);

     return {data}

}

export default useFetch;

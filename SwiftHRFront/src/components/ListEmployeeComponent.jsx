import React, {useEffect, useState} from 'react'
import { listEmployees } from '../services/EmployeeService'

const ListEmployeeComponent = () => {
   const [employees, setEmployees] = useState([])

   useEffect(() => {
    listEmployees().then((response) => {
        setEmployees(response.data);
    }).catch(er => {
        console.error(er);
    });

   }, [])

  return (
    <div className='container'>
        <h2 className='text-center'>List of Employees</h2>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee First Name</th>
                    <th>Emplooyee Last Name</th>
                    <th>Employee Email</th>
                    <th>Employee Position</th>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee => 
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstname}</td>
                            <td>{employee.lastname}</td>
                            <td>{employee.workEmail}</td>
                            <td>{employee.designation}</td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent
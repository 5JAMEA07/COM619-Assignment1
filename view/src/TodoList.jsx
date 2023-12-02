import React, { useEffect, useState } from 'react';
import axios from 'axios';

const TodoList = () => {
    const [todos, setTodos] = useState([]);
    const [isLoading, setIsLoading] = useState(false);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchTodos = async () => {
            setIsLoading(true);
            try {
                const response = await axios.get('http://localhost:8080/api/getAll');
                setTodos(response.data);
            } catch (err) {
                setError('Error fetching todos');
                console.error('Error fetching data: ', err);
            } finally {
                setIsLoading(false);
            }
        };

        fetchTodos();

    }, []);

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
            <h1>final</h1>
            <ul>
                {todos.map(todo => (
                    <li key={todo.id}>
                        {todo.title} - {todo.completed ? 'Completed' : 'Incomplete'}
                        <h5>Nice</h5>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default TodoList;

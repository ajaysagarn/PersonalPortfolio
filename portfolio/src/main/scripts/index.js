import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

let div = document.createElement('div');
div.id = "root";
document.body.append(div);

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  div
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();

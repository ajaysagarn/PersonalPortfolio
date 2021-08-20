import { Router } from '@reach/router'
import React from 'react'
import MainLayout from '../widgets/appshell/MainLayout'


export default function MyRouter () {
  return (
        <Router>
            <MainLayout path="/" />
        </Router>
  )
}

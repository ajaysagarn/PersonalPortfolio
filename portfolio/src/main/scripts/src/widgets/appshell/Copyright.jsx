import React from 'react'
import { Typography, Space } from 'antd';
const { Text, Link } = Typography;

export default function Copyright(){
    return (
        <Space direction="vertical">
            <Text type="secondary">
                {' © '}
                <Link color="inherit" href="https://ajarn.com/">
                Ajay Sagar N
                </Link>{' '}
                {new Date().getFullYear()}
                {'.'}    
            </Text>  
        </Space>
    )
}
import React from 'react'
import { Layout } from 'antd';

const { Sider, Content, Footer } = Layout


export default function MainLayout(){
    return (
        <>
        <Layout>
            <Sider></Sider>
            <Content></Content>
        </Layout>
        <Layout>
            <Footer/>
        </Layout>
      </>
    )
}
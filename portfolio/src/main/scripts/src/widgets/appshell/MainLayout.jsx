import {
    DesktopOutlined, FileOutlined, PieChartOutlined, TeamOutlined,
    UserOutlined
} from '@ant-design/icons';
import { Breadcrumb, Layout, Menu } from 'antd';
import React, { useState } from 'react';
import { Avatar } from 'antd';
import Copyright from './Copyright';
import { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { fetchMenus } from '../../actions/MenuActions';



const { Header, Content, Footer, Sider } = Layout;
const { SubMenu } = Menu;

export default function MainLayout(){

    const [isCollapsed, setIsCollapsed] = useState(false)
    const dispatch = useDispatch();

    const onCollapse = (collapsed, type) =>{
        console.log(collapsed);
        setIsCollapsed(collapsed);
    }

    useEffect(()=>{
        dispatch(fetchMenus())
    },[dispatch])

    return (     
        <Layout style={{ minHeight: '100vh' }}>
        <Sider width={400} collapsible collapsed={isCollapsed} onCollapse={onCollapse}>
          <Avatar size={256} src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />
          <div className="logo" />
          <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
            <Menu.Item key="1" icon={<PieChartOutlined />}>
              Option 1
            </Menu.Item>
            <Menu.Item key="2" icon={<DesktopOutlined />}>
              Option 2
            </Menu.Item>
            <SubMenu key="sub1" icon={<UserOutlined />} title="User">
              <Menu.Item key="3">Tom</Menu.Item>
              <Menu.Item key="4">Bill</Menu.Item>
              <Menu.Item key="5">Alex</Menu.Item>
            </SubMenu>
            <SubMenu key="sub2" icon={<TeamOutlined />} title="Team">
              <Menu.Item key="6">Team 1</Menu.Item>
              <Menu.Item key="8">Team 2</Menu.Item>
            </SubMenu>
            <Menu.Item key="9" icon={<FileOutlined />}>
              Files
            </Menu.Item>
          </Menu>
        </Sider>
        <Layout className="site-layout">
          <Header className="site-layout-background" style={{ padding: 0 }} />
          <Content style={{ margin: '0 16px' }}>
            <Breadcrumb style={{ margin: '16px 0' }}>
              <Breadcrumb.Item>User</Breadcrumb.Item>
              <Breadcrumb.Item>Bill</Breadcrumb.Item>
            </Breadcrumb>
            <div className="site-layout-background" style={{ padding: 24, minHeight: 360 }}>
              Bill is a cat.
            </div>
          </Content>
          <Footer style={{ textAlign: 'center' }}><Copyright/></Footer>
        </Layout>
      </Layout>
    )
}
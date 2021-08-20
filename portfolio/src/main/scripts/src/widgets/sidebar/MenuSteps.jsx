import React from 'react'

import { Steps, Divider } from 'antd';

const { Step } = Steps;

export default function MenuSteps(){
    return (
        <>
        <Steps progressDot current={0} direction="vertical">
          <Step title="Summary" />
          <Step title="Finished" />
          <Step title="In Progress" />
          <Step title="Waiting" />
          <Step title="Waiting" />
        </Steps>
      </>
    )
}
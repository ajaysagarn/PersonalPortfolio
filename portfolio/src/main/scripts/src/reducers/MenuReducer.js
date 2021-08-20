import produce from 'immer'
import { SET_MENUS } from '../actions/MenuActions'


const initialState = {
  status: 'loading' // loaded | loading | error
}

const MenuReducer = produce((newState, action) => {
  const { type, payload } = action
  switch (type) {
    case SET_MENUS: {
      newState.menus = {
        ...payload
      }
      return newState
    }
    default: {
      return newState
    }
  }
}, initialState)

export default MenuReducer

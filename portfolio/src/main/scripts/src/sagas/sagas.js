
import { put, takeEvery } from 'redux-saga/effects'
import { FETCH_MENUS, setMenus } from '../actions/MenuActions'
import API from '../app/api'

const REPO = 'nY5hNtuz'

// worker Saga: will be fired on USER_FETCH_REQUESTED actions
function * fetchMenus (action) {
  try {
    const menus = yield API.get(['api', 'v1', REPO, 'getMenus'])
      .then(res => res?.data || [])
      .catch(res => {
        console.log(res)
      })
    yield put(setMenus(menus))
  } catch (e) {
    console.log(e)
  }
}


function * mySaga () {
  yield takeEvery(FETCH_MENUS, fetchMenus)
}

export default mySaga

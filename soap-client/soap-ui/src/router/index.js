import Vue from 'vue'
import VueRouter from 'vue-router'
import CountryList from '../views/CountryList.vue'
import CountryCreate from '../views/CountryCreate.vue'
import CountryEdit from '../views/CountryEdit.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/countries',
    name: 'country-index',
    component: CountryList
  },
  {
    path: '/countries/create',
    name: 'country-create',
    component: CountryCreate,
  },
  {
    path: '/countries/edit/:id',
    name: 'country-edit',
    component: CountryEdit
  },
  { path: "/", redirect: { name: "country-index" } }
]

const router = new VueRouter({
  routes
})

export default router

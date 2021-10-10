import Vue from 'vue'
import Vuex from 'vuex'
import axios from '../config/axios'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        countries: [],
        loading: false,
        message: ''
    },
    mutations: {
        SET_COUNTRIES(state, countries) {
            state.countries = countries;
        },
        CREATE_COUNTRY(state, country) {
            let countries = state.countries.concat(country);
            state.countries = countries;
        },
        UPDATE_COUNTRY(state, country, idCountry) {
            let countries = state.countries;

            countries.forEach(c => {
                if (c.id == idCountry) {
                    c = country;
                }
            })

            state.countries = countries;
        },
        DELETE_COUNTRY(state, idCountry) {
            let countries = state.countries.filter(c => c.id != idCountry);
            state.countries = countries;
        },
        SET_LOADING(state, loading) {
            state.loading = loading;
        },
        SET_MESSAGE(state, message) {
            state.message = message;
        },
    },
    actions: {
        async loadCountries({ commit }) {
            commit('SET_LOADING', true);

            let response = await axios().get('/countries');

            commit('SET_COUNTRIES', response.data.data);
            commit('SET_LOADING', false);
        },
        async createCountry({ commit }, country) {
            commit('SET_LOADING', true);

            let response = await axios().post('/countries', country);

            commit('SET_COUNTRIES', response.data.country);
            commit('SET_MESSAGE', response.data.message);
            commit('SET_LOADING', false);
        },
        async updateCountry({ commit }, country) {
            commit('SET_LOADING', true);

            let response = await axios().put(`/countries/${country.id}`, {country});
            
            let updatedCountry = response.data;

            commit('UPDATE_COUNTRY', updatedCountry, country.id);
            commit('SET_MESSAGE', response.data.responseStatus.message);
            commit('SET_LOADING', false);

        },
        async deleteCountry({ commit }, country) {
            commit('SET_LOADING', true);

            let response = await axios().delete(`/countries/${country.id}`);

            if (response.status == 200 || response.status == 204) {
                commit('DELETE_COUNTRY', country.id);
                commit('SET_MESSAGE', response.data.responseStatus.message);
                commit('SET_LOADING', false);
            }
        }
    }
})
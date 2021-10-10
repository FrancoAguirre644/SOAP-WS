<template>
    <div v-if="loading" class="spinner-border text-success text-center" role="status">
        <span class="visually-hidden">Loading...</span>
    </div>

    <div v-else class="col-md-8">

    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
        <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
            <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
        </symbol>
    </svg>

    <div class="alert alert-success d-flex align-items-center alert-dismissible fade show" role="alert" v-if="message">
        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
        <div>
            {{ message }}
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>

        <div class="card">
            <div class="card-header d-flex justify-content-between align-items-center m-0 pb-0">
                <span>Countries</span>
                <router-link class="btn btn-success mb-2" :to="{ name: 'country-create'}">
                    + Add Country
                </router-link>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Name</th>
                                <th scope="col">Capital</th>
                                <th scope="col">Population</th>
                                <th scope="col">Currency</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="country in countries" :key="country.id">
                                <th scope="row">{{ country.id }}</th>
                                <td>{{ country.name }}</td>
                                <td>{{ country.capital }}</td>
                                <td>{{ country.population }}</td>
                                <td>{{ country.currency }}</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <router-link class="btn btn-info" :to="{ name: 'country-edit', params : { id : country.id} }">
                                            Edit
                                        </router-link>
                                        <button class="btn btn-danger" @click="deleteCountry(country)">Delete</button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

    import { mapState } from 'vuex'

    export default {
        computed: {
            ...mapState(['countries']),
            ...mapState(['loading']),
            ...mapState(['message']),
        },
        mounted(){
            this.$store.dispatch('loadCountries')
        },
        methods: {
            deleteCountry(country) {
                let confirm = window.confirm(`Are you sure you want to delete ${country.name}`);
                
                if(confirm) {
                    this.$store.dispatch('deleteCountry', country);
                    
                }
            }
        }
    }

</script>

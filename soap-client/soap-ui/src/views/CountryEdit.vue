<template>
  <div class="col-md-8">
    <CountryEditForm :buttonText="'Edit Country'" :country="country" :saveCountry="updateCountry"/>
  </div>
</template>

<script>
    import { mapState } from 'vuex';
    
    import CountryEditForm from '@/components/CountryEditForm';


    export default {
        data() {
            return {

            }
        },
        components: {
            CountryEditForm
        },
        computed: {
            ...mapState(['countries']),
            country() {
                return this.countries.find(c => c.id == this.$route.params.id) || {}
            }
        },
        methods: {
            async updateCountry() {
                await this.$store.dispatch('updateCountry' , this.country);
                this.$router.push({ name: 'country-index'});
            }
        }
    }
    
</script>


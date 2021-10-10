<template>
  <div class="col-md-8">
    <CountryEditForm :buttonText="'Create Country'" :country="country" :saveCountry="createCountry"/>
  </div>
</template>

<script>

  import CountryEditForm from '@/components/CountryEditForm';

  export default {
    data: () => ({
        country: {}
    }),
    components: {
        CountryEditForm
    },
    methods: {
        async createCountry() {
            await this.$store.dispatch('createCountry', this.country);
            this.$router.push({ name: 'country-index'});
        }
    }
  }
</script>

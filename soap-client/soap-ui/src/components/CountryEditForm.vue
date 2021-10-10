<template>
    <div class="card">
      <div class="card-header">{{ buttonText }}</div>
      <div class="card-body">
        <div class="row">
          <div class="col-md-6 mb-3">
            <label class="form-label">Name</label>
            <input type="text" v-model="country.name" class="form-control" />
          </div>
          <div class="col-md-6 mb-3">
            <label class="form-label">Capital</label>
            <input type="text" v-model="country.capital" class="form-control" />
          </div>
          <div class="col-md-6 mb-3">
            <label class="form-label">Population</label>
            <input type="number" v-model="country.population" class="form-control" />
          </div>
          <div class="col-md-6 mb-3">
            <label class="form-label">Currency</label>
            <input type="text" v-model="country.currency" class="form-control" />
          </div>
        </div>
        <hr />
        <button class="btn btn-success w-100" @click="saveCountry">{{ buttonText }}</button>
      </div>
    </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  props: ["country", "saveCountry", "buttonText"],
};
</script>

<template>
  <div class="max-w-[400px] mx-auto mt-20">
    <a-form
      :model="formState"
      name="basic"
      :label-col="{ span: 8 }"
      :wrapper-col="{ span: 16 }"
      autocomplete="off"
      @finish="onFinish"
      @finishFailed="onFinishFailed"
    >
      <a-form-item
        label="Firstname"
        name="firstname"
        :rules="[{ required: true, message: 'Please input your firstname!' }]"
      >
        <a-input v-model:value="formState.firstname" />
      </a-form-item>

      <a-form-item
        label="Lastname"
        name="lastname"
        :rules="[{ required: true, message: 'Please input your lastname!' }]"
      >
        <a-input v-model:value="formState.lastname" />
      </a-form-item>

      <a-form-item
        label="City"
        name="city"
        :rules="[{ required: true, message: 'Please input your city!' }]"
      >
        <a-input v-model:value="formState.city" />
      </a-form-item>
      <a-form-item
        label="Phone"
        name="phone"
        :rules="[{ required: true, message: 'Please input your phone!' }]"
      >
        <a-input v-model:value="formState.phone" />
      </a-form-item>

      <a-form-item
        label="Email"
        name="email"
        :rules="[{ required: true, message: 'Please input your email!' }]"
      >
        <a-input v-model:value="formState.email" />
      </a-form-item>

      <a-form-item
        label="Password"
        name="password"
        :rules="[{ required: true, message: 'Please input your password!' }]"
      >
        <a-input-password v-model:value="formState.password" />
      </a-form-item>

      <a-form-item :wrapper-col="{ offset: 8, span: 16 }">
        <a-button type="primary" html-type="submit">Register</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script lang="ts" setup>
import { reactive } from "vue";
import axios from "axios";

type FormState = {
  firstname: string;
  lastname: string;
  email: string;
  password: string;
  city: string;
  phone: string;
};

const formState = reactive<FormState>({
  firstname: "",
  lastname: "",
  email: "",
  password: "",
  city: "",
  phone: "",
});

const onFinish = async (values: any) => {
  const res = await axios.post("http://localhost:8083/auth/register", values);
  localStorage.setItem(`token ${values.email}`, res.data.token);
  console.log("token by pass register: ", res.data);

  console.log("Success:", values);
};

const onFinishFailed = (errorInfo: any) => {
  console.log("Failed:", errorInfo);
};
</script>

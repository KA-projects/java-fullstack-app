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
        <a-button type="primary" html-type="submit">Login</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script lang="ts" setup>
import { reactive } from "vue";
import axios from "axios";

type FormState = {
  email: string;
  password: string;
};

const formState = reactive<FormState>({
  email: "",
  password: "",
});

const onFinish = async (values: any) => {
  const accessToken = localStorage.getItem(`token ${values.email}`);
  //noble11111@mail.ru
  const res = await axios.post(
    "http://localhost:8083/auth/authenticate",
    values,
    {
      headers: {
        Authorization: `Bearer ${accessToken}`,
      },
    }
  );

  localStorage.setItem(`token ${values.email}`, res.data.token);

  console.log("Success:", values);
};

const onFinishFailed = (errorInfo: any) => {
  console.log("Failed:", errorInfo);
};
</script>

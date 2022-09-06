import React from 'react'
import imagem from '../../assets/Vector.svg'
import style from './NotificationButton.module.css'

const Button = () => {
  return (
    <div className={style.dsmeta_red_btn}>
      <img src={imagem} alt="Notificar" />
    </div>
  )
}

export default Button
